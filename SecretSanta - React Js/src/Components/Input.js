import React, { Fragment } from 'react';
// import { Input } from '@material-ui/core';
import '../CSS/reg.css';

const Input = (props) => {
    let assignClasses = ["inputEle"];
    if (props.touched) {
        if (props.invalid) {
            assignClasses.push("Invalid");
        }
    }
    return (
        <Fragment>
            <label for={props.name}><b>{props.label}</b></label><br />
            <input className={assignClasses.join(' ')}  name={props.name}
                value={props.value}
                onChange={props.changed}
                {...props.elementConfig} />
               {props.touched&&props.invalid&&
               <span className="err-msg ">{props.errMsg}</span>}
            <br />
        </Fragment>
    )
}
export default Input;

