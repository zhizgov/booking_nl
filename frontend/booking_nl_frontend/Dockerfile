#download a base image
FROM node:lts-alpine3.15

# make the 'app' folder the current working directory
WORKDIR /frontend

COPY package*.json ./

#install project dependencies
RUN npm --force install 

#copy project files and folders to the current working directory(i.e. 
#'app' folder)
COPY . .

ENV PORT=3000
#open the port on which the server will start
EXPOSE 3000

#run the front end server
CMD ["npm", "start"]