FROM python:3.8.0-buster
EXPOSE 5000
WORKDIR /microservice_b_python
COPY requirements.txt .
RUN pip install -r requirements.txt
COPY /microservice_b_python .
CMD [ "python", "MessageReader.py"]