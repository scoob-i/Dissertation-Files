import React from "react" ;
import { View } from 'react-native' ;
import Counter from "./Counter.js"

export default class Holder extends React.Component {
    render () {
        return (
            <View style={{flex :1 , alignItems : "center" , justifyContent : "center"}}>
                <Counter milliseconds={this.props.milliseconds } />
                <Counter milliseconds={this.props.milliseconds}/>
                <Counter milliseconds={this.props.milliseconds }/>
                <Counter milliseconds={this.props.milliseconds } />
                <Counter milliseconds={this.props.milliseconds }/>
                <Counter milliseconds={this.props.milliseconds }/>
            </View>
            ) ;
    }
}