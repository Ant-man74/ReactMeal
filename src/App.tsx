import React, { Component } from 'react';
import './App.css';
import Sidebar from './sidebar/sidebar';
import EntrypointComponent from './entrypoint/entrypoint';

class App extends Component {
  render() {
    return (
        <div className="row">
            <div className="col-2">
                <Sidebar />
            </div>
            <div className="col-10">
                <EntrypointComponent />
            </div>
        </div>
    );
  }
}

export default App;
