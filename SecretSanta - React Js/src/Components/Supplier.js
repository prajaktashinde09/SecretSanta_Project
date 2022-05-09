import React from 'react';
import Axios from 'axios';


export default class Supplier extends React.Component{
    constructor() {
        super();
        this.state = {
            selectedFile: null
        }

    }
    handleChange = (e) => {
        e.preventDefault();
        console.log(e.target.files);
        this.setState({
            selectedFile: e.target.files[0]
        });
    }
    onClickHandler = () => {
        const data = new FormData()
        data.append('file', this.state.selectedFile)
        Axios.post("/uploadExcelFile", data, { 
          
       })
     .then(res => { // then print response status
    
         console.log(res.data)
      })
     }
     
    
  

    render(){
        return(
            <>
             <form>
                        <div className="col-md-6">
                            <div className="form-group files color">
                                <label>Upload Your File </label>
                                <input type="file" formEncType="multipart/form-data" className="form-control" name="file" onChange={this.handleChange} />
                            </div>
                            <button type="submit" className="btn btn-primary" onClick={this.onClickHandler}>Submit</button>
                        </div>
                    </form>               

            </>
        );
    }
}