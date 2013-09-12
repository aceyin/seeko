<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Seeko"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css" media="screen">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-theme.css')}" type="text/css" >
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css" media="screen">
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body >
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            Seeko
        </nav>
        <div class="container"></div>
		<g:layoutBody/>
        <script lang="javascript" src="${resource(dir: 'js',file: 'jquery-1.9.1.js')}" type="text/javascript"/>
        <script lang="javascript" src="${resource(dir: 'js',file: 'bootstrap.js')}" type="text/javascript"/>
        <script lang="javascript" src="${resource(dir: 'js',file: 'application.js')}" type="text/javascript"/>
		<r:layoutResources />
	</body>
</html>
