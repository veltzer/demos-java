<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://wwwe.w3.org/2001/XMLSchema"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemalocation="http://www.w3.org/1999/XSL/Transform http://www.w3.org/2005/02/schema-for-xslt20.xsd"
	>
	<xsl:output method="html" omit-xml-declaration="yes" />
	<xsl:template match="/">
		<html>
			<head>
				<title>Book store !</title>
			</head>
			<body>
				<h1>We offer:</h1>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>
	<xsl:template match="book">
		<xsl:value-of select="title" />
		--
		<xsl:value-of select="author" />
		--
		<xsl:value-of select="price" />

		<br />
	</xsl:template>
</xsl:stylesheet>