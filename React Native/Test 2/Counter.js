import React from "react";
import { Text } from 'react-native'
export default class Counter extends React.Component {
    constructor (props) {
        super(props);
        this.state = {
            milliseconds : this.props.milliseconds ,
            counter : 1
        }
        
        setInterval (() =>
            this.setState (prev => (
                {counter : prev.counter + 1 }
            ) ) , this.state.milliseconds ) ;
    }
    render () {
        return(
            <Text>{this.state.counter}</Text>
        ) ;
    };
}
