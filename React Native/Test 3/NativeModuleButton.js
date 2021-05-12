import React from 'react';
import { NativeModules, Button } from 'react-native';

const NewModuleButton = () => {
    //const { GAModule } = NativeModules;
    const { MyGA } = NativeModules;
    const onPress = () => {
        MyGA.runGA();
  };

  return (
    <Button
      title="Click to invoke native module"
      color="#841584"
      onPress={onPress}
    />
  );
};

export default NewModuleButton;