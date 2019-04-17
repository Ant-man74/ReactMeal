import React, { Component } from 'react';
import SidebarItemList from './sidebarList/sidebarList'
import logo from "../ressource/logo.jpg"
import './sidebar.css';

const menuList: string[] = [
    "All Meals",
    "Search Meals",
    "About"
];

class SidebarComponent extends Component {

    render() {
        return (
        <div id="sidebar">
            <div>
                <img id="logo" src={logo}></img>
            </div>
            <div>
                <SidebarItemList items={menuList} />
            </div>
        </div>
        
        );
    }
}

  export default SidebarComponent; // Don’t forget to use export default!
