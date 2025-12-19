# SetUp Guide:
## Backend
1. Clone the Repo `https://github.com/shawnlambert004/TonePolish.git`
2. Navigate to `backend/` folder
3. Add your Groq API key to `application.properties.example`: the creator's key has been provided in the email, rename the file to `application.properties`
4. Build Maven Project
   `mvn clean install # Linux or MacOS`
    `mvnw.cmd clean install # Windows`
## Frontend
1. Navigate to `frontend/` folder
2. Run `npm install`
3. Run `npm run dev`

# AI Transcript 
## Backend
I used chatGPT to generate import necessary libraries and dependencies for the Rest Controller and Service Layer before and after writing the necessary code. The most common prompt being "help me import the necessary packages and what dependencies I may need to add to the pom.xml file. 

For the unit tests I utilised Claude to help with the basic testing structure and appropriate inputs to test functionality

## Frontend

I used Github copilot in visual studio code for assisting with small necessities such as syntax issues alongside claude to aid in handling state management. For example "how can I ensure the button is disabled when making an API call"

# Time Log

- 10m Planning Workflow
- 50m Coding and Debugging (Front End & Back End)
- 10m Controller Layer Unit Test

# Demo
[19_12_2025, 11_39_39 - Screen - Untitled video.webm](https://github.com/user-attachments/assets/dec859bb-137e-4c00-95f5-f5349e547994)



