#Task 2.2

A simple browser client to use the Dropbox API to authorize itself, get account info, upload text files and list files.

#Running locally

1. Download and install Python if you don't have it.
2. Make sure Python is in PATH by typing python on the command line.
3. Browse to the folder containing the source files in the command line.
4. Run python SimpleHTTPServer module with command: python -m SimpleHTTPServer 8000
5. Open your browser and go to: http://localhost:8000

You do not have to use Python server if you don't want to. You just need to get some local server running in the folder that serves from port 8000. This is because Dropbox app only accepts connections from http://localhost:8000 address.

#Usage

1. First push the login button. You will be redirected to Dropbox login.
2. Login with user ties456demos@gmail.com (password demos456).
3. Click Allow to allow authorization.
4. Now you are back in the client. Notice the authorization code given as an URL parameter.
5. Click Auth. This will Authorize the client with the authorization code and give the client the final access token used to perform actions using the API.
6. Now you can retrieve account info, upload a new empty text file and get file listing by pushing the buttons.

Note: You can get more info about the client traffic by opening the browser Javascript console.
