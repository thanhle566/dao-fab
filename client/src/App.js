import './App.css';
import {Route, Switch } from 'react-router-dom';
import Parent from "./components/Parent";
import Child from "./components/Child";
function App() {
  return (
      <div className="App">
          <div className="container">
              <Switch>
                  <Route exact path="/" component={Parent} />
                  <Route path='/:id' component={Child} />
              </Switch>
          </div>
      </div>
  );
}
export default App;
