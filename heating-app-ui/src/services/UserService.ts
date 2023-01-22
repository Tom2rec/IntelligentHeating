import Keycloak from "keycloak-js";

const _kc = Keycloak('/keycloak.json');

/**
 * Initializes Keycloak instance and calls the provided callback function if successfully authenticated.
 *
 * @param onAuthenticatedCallback
 */
const initKeycloak = (onAuthenticatedCallback: any) => {
  _kc.init({
    onLoad: 'check-sso',
    silentCheckSsoRedirectUri: window.location.origin + '/silent-check-sso.html',
    pkceMethod: 'S256',
  })
    .then((authenticated) => {
      if (!authenticated) {
        console.log("user is not authenticated..!");
      }
      onAuthenticatedCallback();
    })
    .catch(console.error);
};

const login = _kc.login;

const logout = _kc.logout;

const getToken = () => _kc.token;

const isLoggedIn = () => !!_kc.token;

const updateToken = (successCallback: any) =>
  _kc.updateToken(5)
    .then(successCallback)
    .catch(login);

const getUsername = () => _kc.tokenParsed?.preferred_username;
const getUserId = () => _kc.tokenParsed.sub;

const hasRole = (roles: []) => roles.some((role) => _kc.hasRealmRole(role));

const UserService = {
  initKeycloak,
  login,
  logout,
  isLoggedIn,
  getToken,
  updateToken,
  getUsername,
  hasRole,
  getUserId
};

export default UserService;
