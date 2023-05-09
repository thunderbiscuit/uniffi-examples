use std::thread;
use rand::Rng;

uniffi::include_scaffolding!("calendar");

pub struct Calendar {
    reminder: Box<dyn Reminder>
}

impl Calendar {
    pub fn new(reminder: Box<dyn Reminder>) -> Self {
        Self { reminder }
    }

    pub fn today(&self) -> String {
        "Today is a good day".to_string()
    }

    pub fn my_reminder(&self) -> String {
        self.reminder.remind_me().unwrap()
    }

    pub fn start(&self) -> () {
        for _ in 0..10 {
            thread::sleep(std::time::Duration::from_secs(4));
            let mut rng = rand::thread_rng();
            let number = rng.gen_range(0..3);
            let event = match number {
                0 => Event::Party,
                1 => Event::Birthday,
                2 => Event::Meeting,
                _ => Event::Party,
            };
            match self.reminder.ping_me(event) {
                Ok(_) => (),
                Err(e) => println!("Error: {:?}", e),
            }
        }
    }
}

pub trait Reminder: Send + Sync + std::fmt::Debug {
    fn remind_me(&self) -> Result<String, CalendarError>;

    fn ping_me(&self, event: Event) -> Result<(), CalendarError>;
}

pub enum Event {
    Party,
    Birthday,
    Meeting,
}

#[derive(Debug)]
pub enum CalendarError {
    EventError,
}

impl std::fmt::Display for CalendarError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "{:?}", self)
    }
}

// Need to implement this From<> impl in order to handle unexpected callback errors.  See the
// Callback Interfaces section of the handbook for more info.
impl From<uniffi::UnexpectedUniFFICallbackError> for CalendarError {
    fn from(_: uniffi::UnexpectedUniFFICallbackError) -> Self {
        Self::EventError
    }
}
