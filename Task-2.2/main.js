var app_key = 'ojtyzbpz7peoc2v';
var app_secret = 'm8kdx1fyrghmj5d';
var access_token = null;

function info() {
  
  var req = $.ajax({
    url: 'https://api.dropboxapi.com/2/users/get_current_account',
    type: 'POST',
    success: function(data, status) {
        console.log(data, status);
        $('#data').text(JSON.stringify(data));
    },
    error: function(data, status) {
        console.error(data.responseText);
    }
  });
}

function login() {
  window.location.replace('https://www.dropbox.com/1/oauth2/authorize?client_id=ojtyzbpz7peoc2v&response_type=code&redirect_uri=http://localhost:8000');
}

function auth() {
  var auth_code = getUrlParameter('code');
  if (!auth_code) return;
  var request = $.ajax({
      type: 'POST',
      url: 'https://api.dropbox.com/1/oauth2/token/',
      data: {
        code: auth_code,
        grant_type: 'authorization_code',
        redirect_uri: 'http://localhost:8000',
        client_id: app_key,
        client_secret: app_secret
      },
      success: function(data, status) {
          var json = JSON.parse(data);
          access_token = json.access_token;
          console.log(access_token);
          console.log(data, status);
      },
      error: function(data, status) {
          console.error(data.responseText);
      }
    });
}

function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};


$.ajaxSetup({
    beforeSend: function(xhr, settings) {
        if (access_token) {    
          xhr.setRequestHeader ("Authorization", "Bearer " + access_token);
        }
    }
});