import React, { Component } from 'react';
import PropTypes from "prop-types";
import './sidebarList.css';

/**
 * Functionnal Component: one element of a menu list
 * @param props.title: the title to display
 */
function SidebarItemComponent (props: any) {
    return (
        <button type="button" className="list-group-item ">{props.title}</button>
    );
};

/**
 * Functionnal Component: A full list of the menu elements given
 * @param props.items: the list of menu items name
 */
function SidebarItemListComponent(props: any) {
    return (
        <div>
            <div className="list-group marginListItem">
                {props.items.map((i: string) => <SidebarItemComponent key={i} title={i} />)}
            </div>
        </div>
    ); 
  } 
  
  export default SidebarItemListComponent;
