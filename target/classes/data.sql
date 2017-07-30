INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	("changevest", "changevestapisecret", "users,read,write",
	"client_credentials", null, null, 36000, 36000, null, true);
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	("changeWeb", "changewebsecret", "change,users,read,write",
	"client_credentials,password,authorization_code,refresh_token", null, null, 36000, 36000, null, true);