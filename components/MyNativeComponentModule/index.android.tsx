// import {View, requireNativeComponent} from 'react-native';

// const settings = {
//      name: 'MyNativeComponent',
//      propTypes: {
//           ...View.propTypes,
//      },
// };

//export const requireNativeComponent('RCTWheelPicker', null);

// export const { MyNativeComponentModule } = ReactNative.NativeModules;

import { NativeModules } from "react-native";

const { MyNativeComponentModule } = NativeModules;

interface MyNativeComponentInterface {
  setMyCustomName(
    name: string,
    failureCallback: (time: number) => void,
    successCallback: (times: number) => void
  ): void;
  setMyCustomNameAsync(name: string): void;
  setMyCustomNameWithRealAsyncTask(name: string): void;
}

export default MyNativeComponentModule as MyNativeComponentInterface;
