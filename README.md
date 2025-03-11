# 📌 Calico Material  

A collection of **Material Design components** for [Calico](https://armanbilge.github.io/calico/), a Scala.js UI library.  
This library allows developers to use Google's **Material Design** components in Calico applications.  

---



# 🛠 Running the Demo
To explore the available Material components:

Build the Sandbox Demo:
```
sbt sandbox/fastLinkJS
```
Start a Local Server:

```
python -m http.server
```
Open in Browser:
Navigate to ```http://localhost:8000/sandbox/``` to see the components in action.


# 🎯 Contribution Guide

### We welcome contributions! If you'd like to add a new Material component:

***Fork & Clone the repository.***

```
git clone https://github.com/armanbilge/calico-material.git
cd calico-material
```
Create a New Branch:

```
git checkout -b feature-new-component
```

***Implement the Feature/Fix***

Follow the existing code structure.
Ensure the component follows Material Design principles.

***Run Tests & Linting:***

```
sbt test
```

***Commit & Push Changes:***

```
git add .
git commit -m "Add new Material Component: XYZ"
git push origin feature-new-component
```

***Open a Pull Request (PR) on GitHub.***

# 💡 Contribution Tips

- If you're adding a major change, open an issue first to discuss it with the maintainers.
- Ensure all tests pass before submitting a PR.
- Follow best practices for Scala.js and Material Design components.

# 📃 License
**This project is licensed under the Apache License 2.0.**
