import React from 'react';
import{ browserHistory } from 'react-router';


export default class Supplier extends React.Component{
    render(){
        localStorage.removeItem("userSessionId");
        localStorage.removeItem("userSessionfirstName");
        const path = '/'
        browserHistory.push(path);
        window.location.reload(false);
        return(
           <></>
        );
    }
}