var exec = require('cordova/exec');

exports.new_activity = function(arg0, success, error) {
    exec(success, error, "CordovaAlarmPlugin", "new_activity", [arg0]);
};


/*var exec = require( 'cordova/exec' );

function plugin() {

}

plugin.prototype.new_activity = function() {
    exec( function(res){}, function(err){}, "CordovaAlarmPlugin", "new_activity", [] );
}

module.exports = new plugin();*/