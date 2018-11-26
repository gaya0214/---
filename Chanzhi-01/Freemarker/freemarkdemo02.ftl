<!DOCTYPE HTML>
<html>
<meta charset="utf-8"/>
<body>
	<h1>蝉知软件测试用例</h1>
	<p>
		<table border="1">
		
			<tr>	
				<td>成功</td>
			</tr>
			<tr>	
				<td>
					<#list success_path as a>${a.method}</#list>
				</td>	
			</tr>
			<tr>
				<td>失败</td>
			</tr>
			<tr>
				<td>
					<#list fail_path as a>${a.method}</#list>
				</td>
			</tr>
		
		</table>
	</p>
</body>
</html>
