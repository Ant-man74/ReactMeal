import React, { Component } from 'react';
import MealList from '../mealList/mealList'
import './entrypoint.css'

enum componentOption {
    mealList = 1,
    search,
    add,
    about,
    error
}

interface Props { value?: any }
interface State { activeComponent :  componentOption }

class entrypointComponent extends React.Component<Props, State> {

    constructor(props: any) {
        super(props);
        this.state = {
            activeComponent: componentOption.mealList
        };
    }

    handleStateChange (id: componentOption) {
        this.setState({activeComponent: id});
    }

    render() {
        let currentState = this.state.activeComponent;
        let activeComponent;

        if (currentState === componentOption.mealList) {
            activeComponent = <MealList />;

        } else if (currentState === componentOption.error) {
            activeComponent = <p>An error occured, no component Loaded</p>;
        }

        return (
            <div className="card" id="main">
                <div className="card-body" >
                    <button type="button" onClick={() => this.handleStateChange(componentOption.mealList)}>mealList</button>
                    <button type="button" onClick={() => this.handleStateChange(componentOption.error)}>error</button>
                    {activeComponent}
                    
                </div>
            </div>
        
        );
    }
}

  export default entrypointComponent; // Don’t forget to use export default!
