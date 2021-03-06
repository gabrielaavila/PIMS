package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ModuleDAO;
import model.entity.Module;

/**
 * Servlet implementation class ModulesServlet
 */
@WebServlet("/ModulesServlet")
public class ModulesServlet extends BootstrapServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModulesServlet() {
        super();
        this.relatedMenuClass = "modules";
        this.layoutType = LayoutType.Grid;
        this.addJavascriptFile("modules.js");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String moduleSlug = this.getModuleSlug(request);
		Module module = this.getModuleFromRequestPath(request);
		
		if (module != null) {
			this.proceedSingleModule(module, request, response);
		} else if (moduleSlug != null) {
			this.setAlertView(AlertType.AlertTypeDanger, "Student not found", request);
			this.proceedSingleModuleError(request, response);
		} else {
			this.proceedModuleList(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void proceedModuleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.relatedMenuClass = "modules"; // Menu for module list
		this.proceedGet("/Modules.jsp", request, response);
	}
	
	protected void proceedSingleModule(Module module, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.relatedMenuClass = "module"; // Menu for selected module
		request.setAttribute("module", module);
		this.proceedGet("/Module.jsp", request, response);
	}
	
	protected void proceedSingleModuleError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.proceedGet("/Module.jsp", request, response);
	}

}
