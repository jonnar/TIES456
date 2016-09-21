var app_key = 'ojtyzbpz7peoc2v';
var app_secret = 'm8kdx1fyrghmj5d';

function auth() {
  $.ajax({
      type: 'POST',
      url: 'https://api.dropbox.com/1/oauth2/token/',
      data: {
        code: 'Q-UXgtawEKAAAAAAAAAAEABuHPT16v7r1_oQCvljvxE',
        grant_type: 'authorization_code',
        client_id: app_key,
        client_secret: app_secret
      },
      success: function(data, status) {
          console.log(data, status);
      },
      error: function(data, status) {
          console.error(data.responseText);
      }
    });

}