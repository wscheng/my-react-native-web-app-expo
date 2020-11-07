import * as React from "react";
import { Text, View } from "../Themed";

const MyHelloWorld: React.FC = (props) => {
  return (
    <View>
      <Text>I'm web component</Text>
      <View accessibilityRole="link" href="http://google.com">
        <Text style={{ color: "blue" }}>Link to google</Text>
      </View>
    </View>
  );
};

export default MyHelloWorld;
