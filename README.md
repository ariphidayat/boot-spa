Spring Boot for Single Page Application Project
===============================================

## Installation
Clone this project or download Zip file

	    $ git clone https://github.com/ariphidayat/boot-spa.git

### Run Project
On command prompt, run the following command:

	$ cd boot-spa

	$ ./gradlew bootRun
	
or run the main method of the Application in the class `BootApplication.java` using your favorite IDE.

### Build Project

	$ ./gradlew build


OAuth2 Flow
===========

### Grand Type : Password

- Request access_token
  
        $ curl -u arip:aripsecret http://localhost:8080/oauth/token -d "grant_type=password&username=user&password=password"
  
- JSON response for `access_token`

        {
            "access_token" : "c31a81f5-e74e-4e93-9db8-a70783c4a503",
            "token_type" : "bearer",
            "refresh_token" : "a0a8281a-6b42-451c-ada4-f2790a3d8468",
            "expires_in" : 3599,
            "scope" : "read write"
        }

- Access resource with header `Authorization: Bearer access_token`
        
        $ curl -H "Authorization: Bearer c31a81f5-e74e-4e93-9db8-a70783c4a503" http://localhost:8080/api/hello
        

### Grand Type : Authorization Code

- Visit authorization endpoint in browser

     http://localhost:8080/oauth/authorize?response_type=code&client_id=alisiana&redirect_uri=http://example.com
        
     once you have authenticated you will get a redirect to `http://example.com` with an authorization code attached. e.g. :
     
     http://example.com/?code=8tWyta
        
- Exchange `code` for an access_token
     
        $ curl -u alisiana:aripsecret http://localhost:8080/oauth/token -d "grant_type=authorization_code&redirect_uri=http://example.com&code=8tWyta"
        
- Access resource with header `Authorization: Bearer access_token`

        $ curl -H "Authorization: Bearer 411b6954-caba-4261-a8d3-7cb41477a2d7" http://localhost:8080/api/hello

        
### Grand Type : Refresh Token
        
        $ curl -u arip:aripsecret http://localhost:8080/oauth/token -d "grant_type=refresh_token&refresh_token=6b270dc0-1351-4acb-8996-54e1f23747c3"