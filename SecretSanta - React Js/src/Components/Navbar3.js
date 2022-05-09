import React, { Component } from "react";
import { NavLink ,withRouter} from "react-router-dom";
import '../CSS/reg.css';

 class Navbar3 extends Component {
  state = {
    navbarState: false,
    navbarClass: "collapse navbar-collapse",
    menus: [
      {
        id: 1,
        text: "Approve",
        url: "/approve"
      },
      {
        id: 2,
        text: "Add Offer",
        url: "/addoffer"
      },

      {
        id: 3,
        text: "Edit / Delete",
        url: "/products"
      }
    ]
  };

  // navbar toggler button
  navbarToggler = () => {
    this.state.navbarState
      ? this.setState({
        navbarState: false,
        navbarClass: "collapse navbar-collapse"
      })
      : this.setState({
        navbarState: true,
        navbarClass: "collapse navbar-collapse show"
      });
  };

  render() {
    console.log("History => ",this.props);
    const{
      match ,location
    }
    =this.props.history;
    return (
      <nav className="navbar navbar-expand-sm nav1 text-white">
        <button
          className="navbar-toggler"
          type="button"
          onClick={this.navbarToggler}
        >
          <span className="text-white">Menu</span>
        </button>
        <div className={this.state.navbarClass}>
          <ul className="navbar-nav ml-auto mr-5">
            {this.state.menus.map(menu => {
              return (
                <li key={menu.id} className="nav-item nav3">
                  <NavLink to={menu.url} exact 
                  activeStyle={{color:"black"}}
                  className="nav-link"
                   isActive=
                    {(match, location) => {
                      if (!match) {
                        return false;
                      }
                      else{
                        
                        return true;
                    }}
                      } 
                  >
                    
                        { menu.text }
                  </NavLink>
                </li>
              );
            })}
          </ul>
        </div>
      </nav>
    );
  }
}
export default withRouter(Navbar3);