import React from 'react';
import '../CSS/reg.css';
import Axios from 'axios';
import{ browserHistory } from 'react-router';
// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';

class Feedback extends React.Component {

  state = {
    emailId: "abc@gmail.xcom",
    name: "",
    ratingId: '1',
  }
  onSubmit = (event) => {
    this.state.name = localStorage.getItem('userSessionId');
    event.preventDefault();

    Axios.post("/feedback", this.state)

      .then((res) => {
        console.log("Axios Response => ", res)
        if(res != null )
        {
          const path = '/';
          browserHistory.push(path);
          window.location.reload(false);
          alert(" Thank You ");

        }
        else{
          alert("feedback fails");

        }
      })
      .catch((err) => {
        console.log("Axios err => ", err)
      })
  }

  handleInput = event => {
    this.setState({ [event.target.name]: event.target.value })
  }
  render() {
    const {
      emailId,
      name
    } = this.state;


    return (
      <>
        <h1 className="head">Feedback</h1>
        <div class="form-style">
          <form action="register">
            <div class="container">


              {/* <label for="Feedback Id"><b>Feedback Id</b></label><br />
              <input type="text" placeholder="FeedbackId "
                name="feedbackId"
                value={feedbackId}
                onChange={this.handleInput}
                required />
              <br /> */}


              {/* <label for="email"><b>Email</b></label><br />
              <input type="text" placeholder="Enter Email"
                name="emailId"
                value={emailId}
                onChange={this.handleInput}
                required />

              <br />
              <label for="Name"><b>Name</b></label><br />
              <input type="text" placeholder="Name"
                name="name"
                value={name}
                onChange={this.handleInput} required />
              <br /> */}

              <label for="Name"><b>Rating</b></label><br />

              <button onClick={() => { this.setState({ ratingId: 1 }) }} type="button" class="btn btn-default btn-lg" id="refresh">
                <span class="glyphicon glyphicon-star-empty fa-1x"></span>
              </button>
              <button onClick={() => { this.setState({ ratingId: 2 }) }} type="button" class="btn btn-default btn-lg" id="refresh">
                <span class="glyphicon glyphicon-star-empty fa-1x"></span>
              </button>
              <button onClick={() => { this.setState({ ratingId: 3 }) }} type="button" class="btn btn-default btn-lg" id="refresh">
                <span class="glyphicon glyphicon-star-empty fa-1x"></span>
              </button>
              <button onClick={() => { this.setState({ ratingId: 4 }) }} type="button" class="btn btn-default btn-lg" id="refresh">
                <span class="glyphicon glyphicon-star-empty fa-1x"></span>
              </button>
              <button onClick={() => { this.setState({ ratingId: 5 }) }} type="button" class="btn btn-default btn-lg" id="refresh">
                <span class="glyphicon glyphicon-star-empty fa-1x"></span>
              </button>
              {/* 
             <span class="glyphicon glyphicon-star-empty fa-2x" onClick={this.onCheck}></span>
              <span class="glyphicon glyphicon-star-empty fa-2x"></span>
              <span class="glyphicon glyphicon-star-empty fa-2x"></span>
              <span class="glyphicon glyphicon-star-empty fa-2x"></span>
              <span class="glyphicon glyphicon-star-empty fa-2x"></span> */}
              <div class="clearfix">

                <button class="btn btn-success" onClick={this.onSubmit}>Submit</button>
              </div>
            </div>
          </form>
        </div>



      </>
    );

  }
}

export default Feedback;


// import React from 'react';
// import './reg.css';
// import Axios from 'axios';

// class Feedback extends React.Component {

//     state = {
//         feedbackId: "1",
//         createdDate: 6-2-2020,
//         emailId: "abc@gmail.xcom",
//         name: "name",
//         // rating:"5"
//       }
//       onSubmit = (event) => {
//         event.preventDefault();
//         Axios.post("/feedback",this.state)

//           .then((res) => {
//             console.log("Axios Response => ", res)
//           })
//           .catch((err) => {
//             console.log("Axios err => ", err)
//           })
//       }

//       handleInput = event => {
//         this.setState({ [event.target.name]: event.target.value })
//       }



//     render() {
//         const { feedbackId,
//             createdDate,
//             emailId,
//             name,
//             rating,
//              } = this.state;
//         return (
//             <>
//                 <div class="form-style">
//                     <form action="register">
//                         <div class="container">

//                             <label for="Feedback Id"><b>Feedback Id</b></label><br />
//                             <input type="text" placeholder="FeedbackId "
//                              name="feedbackId"
//                             value={feedbackId}
//                             onChange={this.handleInput}
//                             required />
//                             <br />

//                             <label for="Created Date"><b>Created Date</b></label><br />
//                             <input type="date" placeholder="Created Date" 
//                             name="createdDate "
//                               value={createdDate}
//                               onChange={this.handleInput}
//                                 required />
//                             <br />

//                             <label for="email"><b>Email</b></label><br />
//                             <input type="text" placeholder="Enter Email" 
//                             name="emailId"
//                                value={emailId}
//                                onChange={this.handleInput}
//                                 required />

//                             <br />
//                             <label for="Name"><b>Name</b></label><br />
//                             <input type="text" placeholder="Name"
//                              name="name"
//                              value={name}
//                              onChange={this.handleInput} required />
//                             <br />

//                             {/* <label for="Name"><b>Name</b></label><br />
//                             <input type="number" placeholder="Name"
//                              name="rating"
//                              value={rating}
//                              onChange={this.handleInput} required />
//                             <br /> */}



//                             <div class="clearfix">

//                                 <button class="btn btn-success"  onClick={this.onSubmit}>Submit</button>
//                             </div>
//                         </div>
//                     </form>
//                 </div>



//             </>
//         );

//     }
// }

// export default Feedback;

