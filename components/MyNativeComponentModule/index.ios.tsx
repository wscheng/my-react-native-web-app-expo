import * as React from "react";
import { Text, View } from "../Themed";

class MyNativeComponentModule extends React.PureComponent {
  static setMyCustomName(
    name: string,
    failureCallback: (time: number) => void,
    successCallback: (times: number) => void
  ) {
    console.log("Method not implemented.");
  }
  static setMyCustomNameAsync(name: string) {
    console.log("Method not implemented.");
  }
  static setMyCustomNameWithRealAsyncTask(name: string) {
    console.log("Method not implemented.");
  }
  render() {
    return (
      <View>
        <Text>iOS not support this yet</Text>
      </View>
    );
  }
}

export default MyNativeComponentModule;
