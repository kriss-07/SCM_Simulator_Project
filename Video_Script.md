# 🎬 SCM Simulator - Video Presentation Script

**Tip for Recording:** Have Android Studio open and the Emulator running. Follow this structural outline to hit all of your grading criteria perfectly.

---

## 1. Introduction (Speaker: Krishna Suri)
**[Visual Action:]** *Show the Main Menu of the App in the Emulator.*

**Krishna:** "Hello everyone, welcome to our presentation for the SCM Simulator—a robust Space Colony Management simulation built entirely natively in Java for Android! 

I am Krishna Suri, and my role was handling the UI Design and Android Implementation. Joining me is Muhammad Musa Adnan, who engineered our core logic and object-oriented backend systems.

Our main objective was to create a tactical turn-based RPG experience mapped directly to strict Object-Oriented Principles. Let me pass it to Muhammad to explain the backend architecture that executes these games rules in the background."

---

## 2. Core Logic & Architecture (Speaker: Muhammad Musa Adnan)
**[Visual Action:]** *Show the IDE, pointing to `CrewMember.java` and `Medic.java`.*

**Muhammad:** "Thank you, Krishna. Under the hood, the SCM Simulator relies on strong OOP paradigms like Polymorphism and Inheritance. We built an abstract `CrewMember` class that acts as the absolute blueprint for all of our simulation data. 

From this abstraction, we created specific subclasses like `Medic`, `Soldier`, `Pilot`, `Scientist`, and `Engineer`. They all naturally inherit core attributes like Health and Energy, however, their specialized abilities execute completely differently during actual mission events—which proves proper Polymorphism."

**[Visual Action:]** *Scroll down and show `Storage.java` logic.*

**Muhammad:** "To securely manage game state without tightly coupling our memory between screens, we integrated a **Singleton Design Pattern** via our `Storage` class. This allows us to persist data globally, keeping perfect track of which characters are actively in the Simulator, the Med Base, or deployed on Missions without suffering from heavy database bloat. 

I'll pass it back to Krishna to show exactly how this logic connects to our stylized user interface."

---

## 3. UI Design & Bonus Features (Speaker: Krishna Suri)
**[Visual Action:]** *Show the 'Crew Quarters' and then move towards 'Mission Control' to deploy a squad in the emulator.*

**Krishna:** "Thanks, Muhammad. On the frontend, we focused on completely stepping away from standard boring text interfaces and instead created an immersive JRPG aesthetic using Android's native XML layout framing. We designed custom Material Cards, integrated drop-down logic, and bound our entire app in a dark, space-age Cyan theme.

**[Visual Action:]** *Deploy the Squad and enter the Combat phase. Attack an enemy to show the animations!*

**Krishna:** "Our biggest bonus feature is our fully animated Combat Encounter phase. Instead of tracking a static combat log, we utilized hardware-accelerated Android `ObjectAnimator` classes. 

When a character Attacks, we dynamically calculate their exact screen coordinates mapped against the enemies coordinates, generating Fireballs that literally fly across the Activity map. Furthermore, when it's a character's turn, we scale their UI card up by 10% and adjust their layout margins in code, physically pushing the other characters away slightly which immediately clarifies the action queue natively!"

---

## 4. Closing (Speaker: Muhammad Musa Adnan)
**[Visual Action:]** *Open the Statistics Menu tracking Wins/Losses.*

**Muhammad:** "By combining tight Java OOP mapping paired securely to Android View controllers, we achieved a modular and scalable game application without performance loss. We've included full instructions and access to our entire codebase inside our GitHub repository." 

"Thank you very much for taking the time to review our SCM Simulator!"
