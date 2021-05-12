import React from 'react';
import {View, FlatList, SafeAreaView, StatusBar, StyleSheet, Text, TouchableOpacity } from "react-native";


function makeItems (){
    const DATA = [];
    for (let i = 0; i < 100; i++){
        DATA.push({
            id: i,
            title: i,
        })
    }
    return DATA
}

const Item = ({ title }) => (
    <View style={styles.item}>
      <Text style={styles.title}>{title}</Text>
    </View>
);


const List = () => {
    const renderItem = ({ item }) => (
        <Item title={item.title}/>
    );
  
    return (
      <SafeAreaView style={styles.container}>
        <FlatList
          data={makeItems()}
          renderItem={renderItem}
          keyExtractor={item => item.id}
          initialNumToRender={100}
        />
      </SafeAreaView>
    );
  }
  
  const styles = StyleSheet.create({
    container: {
      flex: 1,
      marginTop: StatusBar.currentHeight || 0,
    },
    item: {
      backgroundColor: '#f9c2ff',
      padding: 20,
      marginVertical: 8,
      marginHorizontal: 16,
    },
    title: {
      fontSize: 32,
    },
  });

export default List;