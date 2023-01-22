import { Route, Switch } from "react-router-dom";
import Home from "./Home";
import Menu from "./Menu";
import NoMatch from "./NoMatch";
import RolesRoute from "./RolesRoute";
import Secret from "./Secret";

const Main = () => (
  <>
    <Menu />
    <Switch>
      <Route exact path="/">
        <Home />
      </Route>
      <RolesRoute path="/secret" roles={['admin']}>
        <Secret />
      </RolesRoute>
      <Route path="*">
        <NoMatch />
      </Route>
    </Switch>
  </>
)

export default Main
