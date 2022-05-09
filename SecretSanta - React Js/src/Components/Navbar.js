import React, { Component } from "react";
import { Link, NavLink, withRouter } from "react-router-dom";
import '../CSS/reg.css';
import '../index.css';

class Navbar extends Component {
  state = {
    navbarState: false,
    navbarClass: "collapse navbar-collapse",
    menus: [
      {
        id: 1,
        text: "Home",
        url: "/"
      },
      {
        id: 2,
        text: "About",
        url: "/about"
      },
      {
        id: 3,
        text: "Login",
        url: "/Login"
      },
      {
        id: 4,
        text: "Registration",
        url: "/Registration"
      },
      {
        id: 5,
        text: "View Offer",
        url: "/OfferPage"
      }
    ],
    menu2: [
      {
        id: 1,
        text: "Home",
        url: "/"
      },
      {
        id: 2,
        text: "About",
        url: "/about"
      },
      {
        id: 3,
        text: "Find Perfect Gift",
        url: "/PefectGiftage"
      },
      {
        id: 4,
        text: "View Offer",
        url: "/OfferPage"
      },
      {
        id: 5,
        text: "ShowCart",
        url: "/ShowCart"
      },

      {
        id: 6,
        text: "Logout",
        url: "/Logout"
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
    console.log("History => ", this.props);
    const {
      match, location
    }
      = this.props.history;

    if (localStorage.getItem('userSessionId')) {
      return (
        <div className="header">
        <nav className="navbar navbar-expand-sm bg-theme text-white ">
          <Link to="/" className="navbar-brand ml-5">
            <img src={require('../Images/logo.jpg')} alt="Logo" width="8%" />
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            onClick={this.navbarToggler}
          >
            <span className="text-white">Menu</span>
          </button>
          <div className={this.state.navbarClass}>
            <ul className="navbar-nav ml-auto mr-5">


              {this.state.menu2.map(menu => {

                return (
                  <li key={menu.id} className="nav-item nav2">

                    <NavLink to={menu.url} exact
                      activeStyle={{ color: "white" }}
                      className="nav-link"
                      isActive=
                      {(match, location) => {
                        if (!match) {
                          return false;
                        }
                        else {

                          return true;
                        }
                      }
                      }
                    >
                      {menu.text}
                    </NavLink>
                  </li>


                );//end of return
              })}
            </ul>
          </div>
        </nav>
        </div>
      );
    }
    else {
      return (
        <div className="header">
        <nav className="navbar navbar-expand-sm bg-theme text-white ">
          <Link to="/" className="navbar-brand ml-5">
          <img src={require('../Images/logo.jpg')} alt="Logo" width="8%" />
          </Link>
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
                  <li key={menu.id} className="nav-item nav2">

                    <NavLink to={menu.url} exact
                      activeStyle={{ color: "white" }}
                      className="nav-link"
                      isActive=
                      {(match, location) => {
                        if (!match) {
                          return false;
                        }
                        else {

                          return true;
                        }
                      }
                      }
                    >
                      {menu.text}
                    </NavLink>
                  </li>


                );//end of return
              })}
            </ul>
          </div>
        </nav>
        </div>
      );
    }
    // return (
    //   <nav className="navbar navbar-expand-sm bg-theme text-white ">
    //     <Link to="/" className="navbar-brand ml-5">
    //       <img src={require('../Images/logo.jpg')} alt="Logo" width="8%"/>
    //     </Link>
    //     <button
    //       className="navbar-toggler"
    //       type="button"
    //       onClick={this.navbarToggler}
    //     >
    //       <span className="text-white">Menu</span>
    //     </button>
    //     <div className={this.state.navbarClass}>
    //       <ul className="navbar-nav ml-auto mr-5">

    //       if (localStorage.getItem('userSessionId')) 
    //           {

    //           }
    //           else{

    //           }

    //         {this.state.menus.map(menu => {

    //           return (
    //             <li key={menu.id} className="nav-item nav2">

    //               <NavLink to={menu.url} exact 
    //               activeStyle={{color:"white"}}
    //               className="nav-link"
    //                isActive=
    //                 {(match, location) => {
    //                   if (!match) {
    //                     return false;
    //                   }
    //                   else{

    //                     return true;
    //                 }}
    //                   }
    //               >
    //                     { menu.text }
    //               </NavLink>
    //             </li>


    //           );//end of return
    //         })}
    //       </ul>
    //     </div>
    //   </nav>
    // );
  }
}
export default withRouter(Navbar);