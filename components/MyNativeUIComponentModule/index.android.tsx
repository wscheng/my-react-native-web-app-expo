import * as React from "react";
// import {View, requireNativeComponent} from 'react-native';

// const settings = {
//      name: 'MyNativeUIComponent',
//      propTypes: {
//           ...View.propTypes,
//      },
// };

//export const requireNativeComponent('RCTWheelPicker', null);

// export const { MyNativeUIComponentModule } = ReactNative.NativeModules;

import {
  requireNativeComponent,
  View,
  StyleSheet,
  HostComponent,
  StyleProp,
  ViewStyle,
} from "react-native";

//const {MyNativeUIComponentModule } = NativeModules;

// interface MyNativeUIComponentInterface {
//     setMyCustomName(name: string, failureCallback:(time:number)=>void, successCallback:(times:number)=>void): void;
//     setMyCustomNameAsync(name: string): void;
//     setMyCustomNameWithRealAsyncTask(name: string):void;
//  }
var RCTMyNativeUIComponent: HostComponent<{
  style: StyleProp<ViewStyle>;
}> = requireNativeComponent("RCTMyNativeUIComponent");

const MyNativeUIComponentModule: React.FC = (props) => {
  return (
    <View style={{ backgroundColor: "pink", width: "100%", height: 100 }}>
      <RCTMyNativeUIComponent style={styles.nativeUIView} />
    </View>
  );
};

const styles = StyleSheet.create({
  nativeUIView: {
    height: 200,
    width: "100%",
    //backgroundColor:'red'
  },
});

export default MyNativeUIComponentModule;
//export default MyNativeUIComponentModule as MyNativeUIComponentInterface;
