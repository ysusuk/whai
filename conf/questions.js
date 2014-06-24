var questions = [
  "You are almost never late for your appointments?",
  "You like to be engaged in an active and fast-paced job?",
  "You enjoy having a wide circle of acquaintances?",
  "You feel involved when watching TV soaps?",
  "You are usually the first to react to a sudden event, such as the telephone ringing or unexpected question?",
  "You are more interested in a general idea than in the details of its realization",
  "You tend to be unbiased even if this might endanger your good relations with people",
  "Strict observance of the established rules is likely to prevent a good outcome",
  "It's difficult to get you excited",
  "It is in your nature to assume responsibility",
  "You often think about humankind and its destiny",
  "You believe the best decision is one that can be easily changed",
  "Objective criticism is always useful in any activity",
  "You prefer to act immediately rather than speculate about various options",
  "You trust reason rather than feelings",
  "You are inclined to rely more on improvisation than on prior planning",
  "You spend your leisure time actively socializing with a group of people, attending parties, shopping, etc.",
  "You usually plan your actions in advance",
  "Your actions are frequently influenced by emotions",
  "You are a person somewhat reserved and distant in communication",
  "You know how to put every minute of your time to good purpose",
  "You readily help people while asking nothing in return",
  "You often contemplate the complexity of life",
  "After prolonged socializing you feel you need to get away and be alone",
  "You often do jobs in a hurry",
  "You easily see the general principle behind specific occurrences",
  "You frequently and easily express your feelings and emotions",
  "You find it difficult to speak loudly",
  "You get bored if you have to read theoretical books",
  "You tend to sympathize with other people"
]

function insert(question) {
  db.questions.insert({
    text: question,
    answer: false
  })
}

questions.forEach(insert)