
import React from 'react';
import { View, Text, StyleSheet, TextInput, TouchableOpacity, StatusBar} from 'react-native';
import Header from './components/Header';
import List from './components/List';

const App = () => {
  return (
    <View style={styles.container}>
      <Header/>
      <List style={styles.listContainer}/>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 10,
    backgroundColor: "black"
  },
  listContainer: {
    flex: 2,
   
  }
});

export default App;
