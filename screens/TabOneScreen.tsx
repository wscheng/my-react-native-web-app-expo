import * as React from "react";
import { Button, NativeEventEmitter, NativeModules, StyleSheet } from "react-native";

import EditScreenInfo from "../components/EditScreenInfo";
import { Text, View } from "../components/Themed";
import MyHelloWorld from "../components/MyHelloWorld";
import MyNativeComponentModule from "../components/MyNativeComponentModule"

const NewModuleButton = () => {
const onPress = () => {
  console.log('We will invoke the native module here!');
  MyNativeComponentModule.setMyCustomName("MyTest Name: wscheng!",
  (times)=>{
    console.log("Error Times:", times);
  },
  (times)=>{
    console.log("Success Times:", times);
  });
};

return (
  <Button
    title="Click to invoke your native module!"
    color="#841584"
    onPress={onPress}
  />
);
};

const NewModuleAsyncButton = () => {
  const  onPress = async () => {
    console.log('We will invoke the native module here with async!');
    try {
    const times = await MyNativeComponentModule.setMyCustomNameAsync("MyTest Name: wscheng with async!");
    console.log("async back times=",times);
    } catch(e) {
      console.log("get exception:",e);
    }
  
  };
  
  return (
    <Button
      title="Click to invoke your native module with async!"
      color="#841584"
      onPress={onPress}
    />
  );
  };
  

  const NewModuleRealAsyncButton = () => {
    const  onPress = async () => {
      console.log('We will invoke the native module here with REAL async!');
      try {
      const times = await MyNativeComponentModule.setMyCustomNameWithRealAsyncTask("MyTest Name: wscheng with real async!");
      console.log("async back times=",times);
      } catch(e) {
        console.log("get exception:",e);
      }
    
    };
    
    return (
      <Button
        title="Click to invoke your native module with real async!"
        color="#841584"
        onPress={onPress}
      />
    );
    };
    

export default function TabOneScreen() {
  React.useEffect(()=>{
    const eventEmitter = new NativeEventEmitter(NativeModules.ToastExample);
    const eventListener = eventEmitter.addListener('EventReminder', (event) => {
       console.log("RealAsyncTask back==>",event) // "someValue"
    });
    return ()=>{
      eventListener.remove();
    }
  })
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Tab Onetest</Text>
      <MyHelloWorld />
      <View
        style={styles.separator}
        lightColor="#eee"
        darkColor="rgba(255,255,255,0.1)"
      />
      <EditScreenInfo path="/screens/TabOneScreen.js" />
      <NewModuleButton />
      <NewModuleAsyncButton />
      <NewModuleRealAsyncButton />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
  },
  title: {
    fontSize: 20,
    fontWeight: "bold",
  },
  separator: {
    marginVertical: 30,
    height: 1,
    width: "80%",
  },
});
