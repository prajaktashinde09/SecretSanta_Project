import React from 'react';
import '../CSS/reg.css';
import Axios from 'axios';
import Input from './Input';
import{ browserHistory } from 'react-router';
class RegistrationForm1 extends React.Component {
  state = {
    signupForm: {
      firstName: {
        label: "First Name",
        elementConfig: {
          type: 'text',
          placeholder: 'First Name'
        },
        value: '',
        validation: {
          isRequired: true,
        },
        errMsg: 'should not be blank',
        valid: false,
        touched: false
      },
      lastName: {
        label: "Last Name",
        elementConfig: {
          type: 'text',
          placeholder: 'Last Name'
        },
        value: '',
        errMsg: 'should not be blank',
        validation: {
          isRequired: true,
        },
        valid: false,
        touched: false
      },
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
      mobileNumber: {
        label: "Mobile Number",
        elementConfig: {
          type: 'number',
          placeholder: 'Contact Number'
        },
        value: '',
        validation: {
          isRequired: true,
          minLength: 10,
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
      },
      confirmPassword: {
        label: "Confirm Password",
        elementType: 'password',
        elementConfig: {
          type: 'password',
          placeholder: 'Comfirm Password'
        },
        value: '',
        validation: {
          isRequired: true,
          minLength: 6,
          confirmPass: true,
        },
        valid: false,
        touched: false
      },
    },
    isFormValid: false,
  }
  registerUser = ({ serialized, fields, form }) => {
    return fetch('https://backend.dev', {
      body: JSON.stringify(serialized)
    })
  }
  onSignup = (event) => {
    let signUpData = {};
    event.preventDefault();
    if (!this.state.isFormValid)
      return;

    for (let key in this.state.signupForm) {
      if (key !== "confirmPassword")
        signUpData[key] = this.state.signupForm[key].value;
    }

    Axios.post("/UserReg", signUpData)
      .then((res) => {
        if (res.data != "") {
          alert("register successfully")
          const path = '/Login';
          browserHistory.push(path);
          window.location.reload(false);
        }
        else
        {
          alert(" registration fails ");
          window.location.reload(false);

        }
        console.log("Axios Response => ", res)
      })
      .catch((err) => {
        console.log("Axios err => ", err)
      })
     
  }

  isFormValid = (signupForm) => {
    let formValid = true;
    for (let key in signupForm) {
      formValid = signupForm[key].valid && formValid;
    }
    this.setState({ isFormValid: formValid });
  }
  checkValidity(value, rules) {
    let isValid = true;
    if (rules.isRequired) {
      isValid = value.trim() !== '' && isValid;
    }
    if (rules.minLength) {
      isValid = value.length >= rules.minLength && isValid;
    }
    if (rules.maxLength) {
      isValid = value.length
        <= rules.maxLength && isValid;
    }
    if (rules.isEmail) {
      var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      isValid = re.test(value) && isValid;
    }
    if (rules.confirmPass) {
      isValid = this.state.signupForm.password.value === value && isValid;
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
        <h1 className="head">Registration</h1>
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
                {isFormValid ? <button class="btn btn-success" onClick={this.onSignup}>Sign Up</button>
                  : <button class="btn disabled" onClick={this.onSignup}>Sign Up</button>}
              </div>
            </div>
          </form>
        </div>

      </div>
    );
  }
}

export default RegistrationForm1;