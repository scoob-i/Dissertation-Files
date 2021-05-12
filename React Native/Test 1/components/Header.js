import React from 'react';
import { View, Text, StyleSheet, TextInput, TouchableOpacity} from 'react-native';

const Header = () => {
  return (
    <View style={styles.header}>
      <Text style={styles.text}>List</Text>
    </View>
  );
};

const styles = StyleSheet.create({
    header: {
        height: 50,
        padding: 5,
        backgroundColor: '#f8f8f8'
    },
    text: {
        fontSize: 30,
        color: 'black',
        textAlign: 'center'
    }
});

export default Header;