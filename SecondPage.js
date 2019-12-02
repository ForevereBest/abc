import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';

type Props = {};
export default class SecondPage extends Component<Props> {
    render() {
        return  <Text style={{height:500, fontSize:20,backgroundColor:'yellow'}}
        >这是第二个页面</Text>

    }
}