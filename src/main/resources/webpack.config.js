module.exports = {
    "entry": {
        "scala-bundler-test-fastopt": ["/target/scala-2.12/scalajs-bundler/main/scala-bundler-test-fastopt.js"]
    },
    "output": {
        "path": "/home/abdhesh/Documents/Code/scala-bundler-test/target/scala-2.12/scalajs-bundler/main",
        "filename": "[name]-bundle.js"
    },
    "devtool": "source-map",
    "module": {
        "preLoaders": [{
            "test": new RegExp("\\.js$"),
            "loader": "source-map-loader"
        }]
    }
}