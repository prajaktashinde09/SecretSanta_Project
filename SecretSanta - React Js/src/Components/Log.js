
import React from 'react';
import '../CSS/reg.css';
import Axios from 'axios';
import Input from './Input';
import{ browserHistory } from 'react-router';


class LoginForm1 extends React.Component {
  state = {
    signupForm: {

      emailAddress: {
        label: "Email",
        elementConfig: {
          type: 'email',
          placeholder: 'Your E-Mail'
        },
        value: '',
        errMsg: 'should be valid Email ID',
        validation: {
          isEmail: true,
          isRequired: true,
        },
        valid: false,
        touched: false
      },

      password: {
        label: "Password",
        elementType: 'input',
        elementConfig: {
          type: 'password',
          placeholder: 'Password',
        },
        value: '',
        validation: {
          isRequired: true,
          minLength: 6,
        },
        valid: false,
        touched: false
      } 
    },
      isFormValid: false,
      isLoggedIn:0,
      userData:[]
    }

  onSignIn = (event) => {
    //let history = useHistory();
    let signInData = {};
    event.preventDefault();

    for (let key in this.state.signupForm) {
      signInData[key] = this.state.signupForm[key].value;
      console.log(signInData);
    }
    if (!this.state.isFormValid)
      return;

    Axios.post("/user", signInData)
      .then((res) => {
       
        console.log("Axios Response => ", res.data)
        if (res.data != "") {

          alert("logged in successfully");
          
          localStorage.setItem('userSessionId', res.data.id);
          localStorage.setItem('userSessionfirstName', res.data.firstName);
          // setter
          console.log("  local storage sessionId  ====", localStorage.getItem('userSessionId'));
          console.log("  local storage userSessionfirstName  ====", localStorage.getItem('userSessionfirstName'));

          this.setState({ isLoggedIn: 1, userData: res.data })
         
          if (this.state.userData.role.roleName === "user") {
            console.log("role: ", this.state.userData.role.roleName)
            //history.push("/Home");
            
            const path = '/'
            browserHistory.push(path);
            window.location.reload(false);
            
          }
          else if(this.state.userData.role.roleName === "admin")
          {
            console.log("role: ", this.state.userData.role.roleName)
            const path = '/Admin'
            browserHistory.push(path);
            window.location.reload(false);
          }
          else if(this.state.userData.role.roleName === "supplier")
          {
            console.log("role: ", this.state.userData.role.roleName)
            const path = '/Supplier'
            browserHistory.push(path);
            window.location.reload(false);
          }
         
        }//end of if
        else{
          alert(" email or password is wrong please login again ");
          window.location.reload(false);
          
        }

      })//end of then
      .catch((err) => {
       
        console.log("Axios err => ", err)
        alert("Error");
       
      })//end of axois call

    }

  isFormValid = (signupForm) => {
    let formValid = true;
    for (let key in signupForm) {
      formValid = signupForm[key].valid && formValid;
    }
    this.setState({ isFormValid: formValid });
  }

  checkValidity(value, rules){
    let isValid = true;
    if (rules.isRequired) {
      isValid = value.trim() !== '' && isValid;
    }
    if (rules.minLength) {
      isValid = value.length >= rules.minLength && isValid;
    }
    
    if (rules.isEmail) {
      var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      isValid = re.test(value) && isValid;
    }
   
    return isValid;
  }


  inputChagedHandler = (event, eleIdentifier) => {
    const updatedSignupForm = { ...this.state.signupForm }
    const updatedSignupElement = { ...updatedSignupForm[eleIdentifier] }
    updatedSignupElement.value = event.target.value;
    updatedSignupElement.valid = this.checkValidity(updatedSignupElement.value,
      updatedSignupElement.validation);
    updatedSignupElement.touched = true;
    updatedSignupForm[eleIdentifier] = updatedSignupElement;
    this.isFormValid(updatedSignupForm)
    this.setState({ signupForm: updatedSignupForm })
  }
  render() {
    const { signupForm, isFormValid } = this.state;
    let formElementsArray = [];
    for (let key in signupForm) {
      formElementsArray.push({
        id: key,
        config: this.state.signupForm[key]
      })
    }
    return (
      <div class="body1">
        <h1 className="head"> Login </h1>
        <div class="form-style">
          <form action="register">
            <div class="container">

              {formElementsArray.map(ele => {
                return (<Input
                  key={ele.id}
                  name={ele.id}
                  elementConfig={ele.config.elementConfig}
                  value={ele.config.value}
                  label={ele.config.label}
                  invalid={!ele.config.valid}
                  touched={ele.config.touched}
                  placeholder={ele.config.placeholder}
                  errMsg={ele.config.errMsg}
                  changed={(event) => this.inputChagedHandler(event, ele.id)} />);
              })}
              <div class="clearfix">
                {isFormValid ? <button class="btn btn-success" onClick={this.onSignIn}>Sign In</button>
                  : <button class="btn disabled" onClick={this.onSignIn}>Sign </button>}
              </div>
              <div><br></br> </div>
              <span class="forgot-password">
                   <a href="no-javascript1.html" title="Forgot Password" id="link-reset">Forgot Password?</a>
                </span>
            </div>
          </form>
          
        </div>
        

      </div>
    );
  }
}

export default LoginForm1;