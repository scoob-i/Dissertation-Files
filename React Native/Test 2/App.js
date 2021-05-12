import React from "react" ;
import { View } from 'react-native' ;
import Holder from "./Holder.js";

export default class App extends React.Component {
  constructor (props){
    super(props);
    this.milliseconds = 1;

  }

    render () {
      return (
        <View style={{flex :1 , alignItems :"center" , justifyContent : "center" }}>
          <Holder milliseconds={this.milliseconds }/>
          <Holder milliseconds={this.milliseconds}/>
          <Holder milliseconds={this.milliseconds}/>
          <Holder milliseconds={this.milliseconds}/>
        </View>
      ) ;
    }
}