<%@ include file="Header.jsp"%>

<div class="jumbotron">
	<form class="form-horizontal" role="form" action="" method="post">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputUsername3" 
					placeholder="Username" name="username">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password" name="password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<select name="user" style="width: 200px">
					<c:forEach items="${ userTypes }" var="userType">
						<option value="${ userType }">${ userType }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
		</div>
	</form>
</div>

<%@ include file="Footer.jsp"%>