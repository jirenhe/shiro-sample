
if (typeof define !== 'function') {
  // to be able to require file from node
  var define = require('amdefine')(module);
}
/**
 * 配置requirejs
 * 模块路径缩写，版本管理
 */
window.require.config({
	baseUrl : 'js',
	paths: {
        'jquery': '../common/jslib/jquery/jQuery-2.1.4.min',
        'jquery_validate': '../common/jslib/jquery.validate/jquery.validate',
        'jquery_form': '../common/jslib/jquery.form/jquery.form',
    },

    shim: {
        'jquery_validate': ['jquery'],
    }
});