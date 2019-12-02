import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View,Button} from 'react-native';
// import { StackNavigator } from 'react-navigation';
import SecondPage from './SecondPage'
// import { StackNavigator } from 'react-navigation';
import { StackNavigator } from 'react-navigation';
// type Props = {};
export default class FirstPage extends Component{
    render() {
        const { navigate } = this.props.navigation;
        return (
        // <Text style={{height:100, fontSize:20,backgroundColor:'red'}}
        //               onPress={() => navigate('SecondPage',{description:'price:$300'})}
        // >点击跳转页面</Text>
        <View>
            <Text >Navigation主页面!</Text>
            <Button onPress={() => navigate('SecondPage',{description:'price:$300'})} title="GET DETAIL"/>
        </View>
        )

    }
}
// 将HomeScreen和DetailScreen在StackNavigator中注册
const SimpleApp = StackNavigator({
    First: {screen: FirstPage},
    Second:{screen:SecondPage},
});