import axios from "axios";
import UserService from "./UserService";

const _axios = axios.create({
  baseURL: process.env.REACT_APP_BASE_URL
});

const configure = () => {
  _axios.interceptors.request.use((config) => {
    if (UserService.isLoggedIn()) {
      const cb = () => {
        config.headers!.Authorization = `Bearer ${UserService.getToken()}`;
        return Promise.resolve(config);
      };
      return UserService.updateToken(cb);
    }
  });
};

const HttpService = {
  configure,
  client: _axios,
};

export default HttpService;
