import * as Linking from "expo-linking";
import { Platform } from "react-native";

export default {
  prefixes: [
    Platform.OS == "web" ? Linking.makeUrl("/") : "myapp",
    //  select({
    //   web: Linking.makeUrl("/"),
    //   android: "myapp",
    //   ios: "myapp",
    // }),
  ],
  config: {
    screens: {
      Root: {
        screens: {
          TabOne: {
            screens: {
              TabOneScreen: "one",
            },
          },
          TabTwo: {
            screens: {
              TabTwoScreen: "two",
            },
          },
        },
      },
      NotFound: "*",
    },
  },
};
