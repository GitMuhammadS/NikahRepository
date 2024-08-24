<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>marriage_seeker_register</title>
</head>
<body>
		<h1 style="color:red;text-align:center">marriage_seeker_register</h1>
		<form:form modelAttribute="profile" enctype="multipart/form-data">
			<table bgcolor="cyan" align="center">
				<tr>
					<td>Marriage seeker Name</td>
					<td><form:input path="profileName"/></td>
				</tr>
				
				<tr>
					<td>Marriage seeker Gender</td>
					<td>
						<form:radiobutton path="gender" value="male"/>Male &nbsp; &nbsp;
						<form:radiobutton path="gender" value="female"/>Female
					</td>
				</tr>
				<tr>
					<td>Select Resume</td>
					<td><form:input type="file" path="resume"/></td>
				</tr>
				
				<tr>
					<td>Select Photo</td>
					<td><form:input type="file" path="photo"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="REGISTER">
					<td><input type="reset" value="CANCEL"></td>
				</tr>
			</table>
		</form:form>
		
		<p style="text-align:center;color:red">
			ResumeFile ${resumeFileName}
			PhotoFile  ${photoFileName }
			Result     ${msg }
		</p>
		
</body>
</html>