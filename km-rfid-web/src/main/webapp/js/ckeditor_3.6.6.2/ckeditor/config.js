/*
Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	//config.filebrowserUploadUrl = ctx + "/upload/ckeditor.action"; //固定路径
	//config.filebrowserBrowseUrl = ctx + "/upload/ckeditor.action"; //固定路径
    config.filebrowserImageUploadUrl = ctx + "/upload/ckeditor.action"; //固定路径
    //config.filebrowserFlashUploadUrl= ctx + "/upload/ckeditor.action"; //固定路径
};
